package com.xenosnowfox.twitchjavaclient.authentication.oauth2;

import com.xenosnowfox.twitchjavaclient.authentication.TwitchAuthenticationClient;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class OAuth2AccessToken {

	private TwitchAuthenticationClient twitchAuthenticationClient;

	private String accessToken;

	private String refreshToken;

	private Integer expiresIn;

	private final Set<String> scopes = new HashSet<>();

	private String tokenType;

	private OAuth2AccessToken() {
	}

	private OAuth2AccessToken(final OAuth2AccessToken other) {
		Objects.requireNonNull(other);
		this.twitchAuthenticationClient = Objects.requireNonNull(other.twitchAuthenticationClient);
		this.accessToken = Objects.requireNonNull(other.accessToken);
		this.refreshToken = Objects.requireNonNull(other.refreshToken);
		this.expiresIn = Objects.requireNonNull(other.expiresIn);
		this.tokenType = Objects.requireNonNull(other.tokenType);
		this.scopes.addAll(other.scopes);
	}

	public static class Builder {

		private final OAuth2AccessToken token = new OAuth2AccessToken();

		public Builder withAuthenticationClient(final TwitchAuthenticationClient withClient) {
			this.token.twitchAuthenticationClient = Objects.requireNonNull(withClient);
			return this;
		}

		public Builder withAccessToken(final String withToken) {
			this.token.accessToken = Objects.requireNonNull(withToken);
			return this;
		}

		public Builder withRefreshToken(final String withToken) {
			this.token.refreshToken = Objects.requireNonNull(withToken);
			return this;
		}

		public Builder withExpiresIn(final Integer withSeconds) {
			this.token.expiresIn = Objects.requireNonNull(withSeconds);
			return this;
		}

		public Builder withScopes(final Set<String> withToken) {
			this.token.scopes.clear();
			this.token.scopes.addAll(Objects.requireNonNull(withToken));
			return this;
		}

		public Builder withTokenType(final String withType) {
			this.token.tokenType = Objects.requireNonNull(withType);
			return this;
		}

		public OAuth2AccessToken build() {
			return new OAuth2AccessToken(this.token);
		}
	}
}
