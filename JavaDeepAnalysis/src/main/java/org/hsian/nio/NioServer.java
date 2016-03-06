package org.hsian.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by Hsian on 16/1/30.
 *
 * @author Hsian
 * @since 1.0, 16/1/30
 */
public class NioServer {


	public static void main(String[] args) {
		try {
			NioServer nioServer = new NioServer(null, 9999);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Selector selector;
	private ServerSocketChannel serverChannel;

	public NioServer(InetAddress address, int port) throws IOException {
		// 打开检查器
		selector = Selector.open();
		// 打开套接字通道
		serverChannel = ServerSocketChannel.open();
		// 绑定IP地址与端口
		serverChannel.socket().bind(new InetSocketAddress(address, port));
		// 设定阻塞方式
		serverChannel.configureBlocking(false);
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
	}
}
