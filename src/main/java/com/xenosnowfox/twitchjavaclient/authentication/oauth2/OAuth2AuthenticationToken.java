package com.xenosnowfox.twitchjavaclient.authentication.oauth2;

import com.xenosnowfox.twitchjavaclient.authentication.TwitchAuthenticationClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class OAuth2AuthenticationToken {

	private TwitchAuthenticationClient twitchAuthenticationClient;

	private String authenticationToken;

	private String callbackUri;

	private String state;

	private OAuth2AuthenticationToken() {
	}

	private OAuth2AuthenticationToken(final OAuth2AuthenticationToken other) {
		Objects.requireNonNull(other);
		this.twitchAuthenticationClient = Objects.requireNonNull(other.twitchAuthenticationClient);
		this.authenticationToken = Objects.requireNonNull(other.authenticationToken);
		this.callbackUri = Objects.requireNonNull(other.callbackUri);
		this.state = Objects.requireNonNull(other.state);
	}

	public CompletableFuture<String> exchangeForAccessToken() {

		var queryString = new ArrayList<String>();

		final var request = HttpRequest.newBuilder()
				.uri(URI.create("https://id.twitch.tv/oauth2/token?"))
				.POST(HttpRequest.BodyPublishers.noBody())
				.build();

		final var client = HttpClient.newHttpClient();

		return CompletableFuture.supplyAsync(() -> {
			try {
				var response = client.send(request, HttpResponse.BodyHandlers.ofString());

				if (response.statusCode() >= 400) {
					return null;
				}

				var objectMapper = new ObjectMapper();

				return null;
			} catch (IOException | InterruptedException ex) {
				throw new CompletionException(ex);
			}
		});
	}

	public static class Builder {

		private final OAuth2AuthenticationToken token = new OAuth2AuthenticationToken();

		public Builder withAuthenticationClient(final TwitchAuthenticationClient withClient) {
			this.token.twitchAuthenticationClient = Objects.requireNonNull(withClient);
			return this;
		}

		public Builder withAuthenticationToken(final String withToken) {
			this.token.authenticationToken = Objects.requireNonNull(withToken);
			return this;
		}

		public Builder withCallbackUri(final String withCallbackUri) {
			this.token.callbackUri = Objects.requireNonNull(withCallbackUri);
			return this;
		}

		public Builder withState(final String withState) {
			this.token.state = withState;
			return this;
		}

		public OAuth2AuthenticationToken build() {
			return new OAuth2AuthenticationToken(this.token);
		}
	}
}
