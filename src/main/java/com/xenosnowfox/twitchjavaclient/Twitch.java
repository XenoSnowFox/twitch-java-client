package com.xenosnowfox.twitchjavaclient;

public abstract class Twitch {

	public static final String API_VERSION = "2021-10-01";
	public static final String AUTH_URL_BASE = "https://id.twitch.tv";
	public static final String API_URL_BASE = "https://api.twitch.tv";

	public static TwitchClient.Builder clientBuilder() {
		return new TwitchClient.Builder();
	}
}
