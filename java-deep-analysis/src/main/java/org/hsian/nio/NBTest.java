package org.hsian.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Hsian on 15/12/22.
 *
 * @author Hsian
 * @since 1.0
 */
public class NBTest {

	public void startServer() {

		int channels = 0;
		int nKeys;
		try {
			// Selector
			// 打开使用检查器
			Selector selector = Selector.open();
			// 服务端套接字通道
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			// 构造地址
			InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 9999);
			// 绑定地址
			serverSocketChannel.socket().bind(inetSocketAddress);
			// 设定blocking方式
			serverSocketChannel.configureBlocking(false);
			// 往selector里注册channel以及我们的感兴趣的事件
			SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			printKeyInfo(selectionKey);
			while (true) {

				nKeys = selector.select();
				if (nKeys > 0) {
					Set<SelectionKey> selectedKeys = selector.keys();
					Iterator<SelectionKey> it = selectedKeys.iterator();
					while (it.hasNext()) {
						selectionKey = it.next();
						printKeyInfo(selectionKey);
						println("NBTest: Nr Keys in selector: " + selector.keys().size());
						it.remove();
						if (selectionKey.isAcceptable()) {
							Socket socket = ((ServerSocketChannel) selectionKey.channel()).accept().socket();
							SocketChannel socketChannel = socket.getChannel();
							socketChannel.configureBlocking(false);
							socketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
							System.out.println(++channels);
						} else {
							println("NBTest: Channel not acceptable");
						}
					}
				} else {
					println("NBTest: Select finished without any keys.");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void printKeyInfo(SelectionKey sk) {
		String s;

		s = "Att: " + (sk.attachment() == null ? "no" : "yes");
		s += ", Read: " + sk.isReadable();
		s += ", Acpt: " + sk.isAcceptable();
		s += ", Cnct: " + sk.isConnectable();
		s += ", Wrt: " + sk.isWritable();
		s += ", Valid: " + sk.isValid();
		s += ", Ops: " + sk.interestOps();
		println(s);
	}

	private static void println(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		NBTest nbTest = new NBTest();
		nbTest.startServer();
	}
}
