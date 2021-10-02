package com.xenosnowfox.twitchjavaclient.clients;

import java.util.Objects;
import java.util.Properties;

public class TwitchClient {

	private String clientId;

	private String clientSecret;

	private TwitchClient() {
	}

	private TwitchClient(final TwitchClient other) {
		Objects.requireNonNull(other);
		this.clientId = other.clientId;
		this.clientSecret = other.clientSecret;
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
