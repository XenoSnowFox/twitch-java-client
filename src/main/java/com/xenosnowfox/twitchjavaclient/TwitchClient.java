package com.xenosnowfox.twitchjavaclient;

import com.xenosnowfox.twitchjavaclient.authentication.TwitchAuthenticationClient;

import java.util.Objects;
import java.util.Properties;

public class TwitchClient {

	private String clientId;

	private String clientSecret;

	private TwitchAuthenticationClient twitchAuthenticationClient;

	private TwitchClient() {
	}

	private TwitchClient(final TwitchClient other) {
		Objects.requireNonNull(other);
		this.clientId = other.clientId;
		this.clientSecret = other.clientSecret;
	}

	String getClientId() {
		return this.clientId;
	}

	String getClientSecret() {
		return this.clientSecret;
	}

	public TwitchAuthenticationClient authentication() {
		if (this.twitchAuthenticationClient == null) {
			this.twitchAuthenticationClient = new TwitchAuthenticationClient(this);
		}
		return this.twitchAuthenticationClient;
	}


	public static class Builder {

		private static final String CLIENT_ID = "Client-Id";

		private static final String CLIENT_SECRET = "Client-Secret";

		private final TwitchClient client = new TwitchClient();

		public Builder fromProperties(final Properties withProperties) {
			Objects.requireNonNull(withProperties);
			if (withProperties.containsKey(CLIENT_ID)) {
				this.withClientId(withProperties.getProperty(CLIENT_ID));
			}
			if (withProperties.containsKey(CLIENT_SECRET)) {
				this.withClientSecret(withProperties.getProperty(CLIENT_SECRET));
			}
			return this;
		}

		public Builder withClientId(final String withClientId) {
			this.client.clientId = Objects.requireNonNull(withClientId);
			return this;
		}

		public Builder withClientSecret(final String withClientSecret) {
			this.client.clientSecret = Objects.requireNonNull(withClientSecret);
			return this;
		}

		public Builder withClientCredentials(final String withClientId, final String withClientSecret) {
			return this.withClientId(withClientId)
					.withClientSecret(withClientSecret);
		}

		public TwitchClient build() {
			return new TwitchClient(this.client);
		}
	}
}
