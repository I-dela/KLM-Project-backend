package Klm1.KLMLineMaintenanceServer.repositories.security;


import Klm1.KLMLineMaintenanceServer.models.helper.AuthenticationException;
import io.jsonwebtoken.*;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

public class JWToken {

  // A claim indicating if the user is an administrator
  public static final String JWT_USERNAME_CLAIM = "sub";
  public static final String JWT_USERID_CLAIM = "id";
  public static final String JWT_ROLE_CLAIM = "role";


  private String username = "YSN";
  private String userId = null;
  private String role = "ADM";

  public JWToken() {
  }

  public JWToken(String username, String userId, String role) {
    this.username = username;
    this.userId = userId;
    this.role = role;

  }

  //Generate a Json Web Token
  public String encode(String passphrase, String issuer, int expiration) {

    Key key = getKey(passphrase);

    String token = Jwts.builder()
      .claim(JWT_USERNAME_CLAIM,this.username)
      .claim(JWT_USERID_CLAIM,this.userId)
      .claim(JWT_ROLE_CLAIM,this.role)
      .setIssuer(issuer) // registered claim
      .setIssuedAt(new Date()) // registered claim
      .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000)) // registered claim
      .signWith(key, SignatureAlgorithm.HS512)
      .compact();

    return token;
  }

  private static Key getKey(String passPhrase) {
    byte hmacKey[] = passPhrase.getBytes(StandardCharsets.UTF_8);
    Key key = new SecretKeySpec(hmacKey, SignatureAlgorithm.HS512.getJcaName());
    return key;
  }

  public static JWTokenInfo decode(String encodedToken, String passphrase) throws AuthenticationException {
    try {
      // Validate the token
      Key key = getKey(passphrase);
      Jws<Claims> jws = Jwts.parser().setSigningKey(key).parseClaimsJws(encodedToken);
      Claims claims = jws.getBody();



          JWTokenInfo jwToken = new JWTokenInfo();

      jwToken.setId(claims.get(Claims.SUBJECT).toString());
//      jwToken.setRole(claims.get(Claims.SUBJECT).toString());




      return jwToken;

    } catch (ExpiredJwtException | MalformedJwtException |
      UnsupportedJwtException | IllegalArgumentException| SignatureException e) {
      throw new AuthenticationException(e.getMessage());
    }
  }

}
