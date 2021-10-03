package com.xenosnowfox.twitchjavaclient.authentication;

import com.xenosnowfox.twitchjavaclient.authentication.oauth2.OAuth2AuthenticationToken;
import com.xenosnowfox.twitchjavaclient.TwitchClient;

import java.util.Objects;

public class TwitchAuthenticationClient {

	private final TwitchClient twitchClient;

	public TwitchAuthenticationClient(final TwitchClient withTwitchClient) {
		this.twitchClient = Objects.requireNonNull(withTwitchClient);
	}

	public OAuth2AuthenticationToken.Builder oauth2AuthenticationTokenBuilder() {
		return new OAuth2AuthenticationToken.Builder().withAuthenticationClient(this);
	}


}
