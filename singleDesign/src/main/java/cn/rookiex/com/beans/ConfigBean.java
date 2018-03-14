package cn.rookiex.com.beans;


public class ConfigBean {

	private String ip = "127.0.0.1";

	private int port = 8090;

	private String log = "/tmp/logs/game.log";


	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getPort() {
		return port;
	}

	public String getIp() {
		return ip;
	}

	public String getLog() {
		return log;
	}
}
