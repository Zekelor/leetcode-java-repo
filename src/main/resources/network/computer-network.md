<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](https://github.com/thlorenz/doctoc)*

- [HTTP](#http)
  - [HTTP 1.0 和 HTTP 1.1 的主要区别](#http-10-%E5%92%8C-http-11-%E7%9A%84%E4%B8%BB%E8%A6%81%E5%8C%BA%E5%88%AB)
  - [HTTP/2.0 相比1.0的改进](#http20-%E7%9B%B8%E6%AF%9410%E7%9A%84%E6%94%B9%E8%BF%9B)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->


# HTTP
> HTTP协议是Hyper Text Transfer Protocol（超文本传输协议）的缩写,是用于从万维网（WWW:World Wide Web ）服务器传输超文本到本地浏览器的传送协议。

## HTTP 1.0 和 HTTP 1.1 的主要区别
> HTTP 1.0 最早在网页中的使用是在 1996 年，那个时候只是使用一些较为简单的网页和网络请求上，而 HTTP 1.1 则在 1999 年才开始广泛应用于现在的各大浏览器网络请求中，同时 HTTP 1.1 
> 也是当前使用最为广泛的 HTTP 协议。

两者主要区别： 

1. __长连接__: 
   
   在 HTTP/1.0 中，默认使用的是短连接，也就是每次请求都要重新建立一次连接。HTTP 是基于 TCP/IP 
   协议的，每一次建立或者断开连接，都需要三次握手四次挥手的开销，如果每次请求都要这样的话，开销会比较大，因此最好能维持一个长连接，可以用长连接来发多个请求。
   <mark>HTTP 1.1 起，默认使用长连接 `Connection： keep-alive `。 </mark>
   HTTP/1.1 的持续连接，
   有<mark>非流水线方式</mark>和<mark>流水线方式</mark> 。
   流水线方式，是客户在收到 HTTP 的响应报文之前，就能接着发送新的请求报文；与之相对应的非流水线方式，是客户在收到前一个响应后才能发起下一个请求；
2. __错误响应码__：
   
	在 HTTP 1.1 中，新增了 24 个错误状态响应码，如 409（Conflict）：表示请求的资源与资源的当前状态发生冲突；410（Gone）：表示服务器上的某个资源被永久性的删除；

3. __缓存处理__： 
	
	HTTP 1.0 中，主要使用 header 头里的 `If-Modified-Since`、<code>Expires</code> 来做为缓存判断的标准；HTTP 1.1，则引入了更多的缓存控制策略，如 
   `Entity tag`，`If-Unmodified-Since`, `If-Match`, `If-None-Match` 等；

4. __带宽优化及网络连接的使用__：HTTP 1.0 中，存在一些浪费带宽的现象，例如客户端只是需要某个对象的一部分，而服务器却将整个对象传送了过来，并且不支持断点续传功能；HTTP 1.1 中，则在请求头引入了 range 
   头域，它允许只请求资源的某个部分，即返回码是 206（Partial Content），这样方便开发者自由的选择，以便于充分利用带宽和连接。

## HTTP/2.0 相比1.0的改进
1、__多路复用__

多路复用允许同时通过单一的HTTP/2连接发起多重的请求-响应消息

2、__二进制分帧__

HTTP/2为了改进传输性能、实现低延迟和高吞吐量，在应用层（HTTP/2）和传输层（TCP or UDP）之间增加一个二进制分帧层，在二进制分帧层中， HTTP/2 会将所有传输的信息分割为更小的消息和帧（frame）,并对它们采用二进制格式的编码。

3、__首部压缩__

HTTP/1.1并不支持 HTTP 首部压缩，而 HTTP/2 则使用了专门为首部压缩而设计的 HPACK 算法

4、__服务端推送__

服务端推送是一种在客户端请求之前发送数据的机制。在 HTTP/2 中，服务器可以对客户端的一个请求发送多个响应。如果客户端早已在缓存中有了一份 copy，HTTP/2 允许客户端通过 RESET_STREAM 主动取消 Push 。另一个方案，客户端使用一个简洁的 Cache Digest 来告诉服务器，哪些东西已经在缓存，因此服务器也就会知道哪些是客户端所需要的。