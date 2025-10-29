package com.englishcenter.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import org.springframework.stereotype.Component;
import java.security.Key; import java.util.Date;

@Component public class JwtUtil {
  private static final String SECRET="thisIsASecretKeyForEnglishCenterDemoProject123456";
  private static final long EXP=86400000L; // 1 day
  private final Key key= Keys.hmacShaKeyFor(SECRET.getBytes());
  public String generate(String username,String role){
    return Jwts.builder().setSubject(username).claim("role",role)
      .setIssuedAt(new Date()).setExpiration(new Date(System.currentTimeMillis()+EXP))
      .signWith(key, SignatureAlgorithm.HS256).compact();
  }
  public boolean valid(String t){ try{ Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(t); return true;}catch(Exception e){return false;} }
  public String user(String t){ return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(t).getBody().getSubject(); }
}
