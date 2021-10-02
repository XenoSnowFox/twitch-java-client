package com.xenosnowfox.twitchjavaclient.clients;

import java.util.Objects;

public class TwitchAuthenticationClient {

	private final TwitchClient twitchClient;

	TwitchAuthenticationClient(final TwitchClient withTwitchClient) {
		this.twitchClient = Objects.requireNonNull(withTwitchClient);
	}


}
