package cn.edu.cqut.crmservice.util;


import cn.edu.cqut.crmservice.entity.SysUser;
import io.jsonwebtoken.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component

public class JWTUtil {
    //JWT秘钥
    private String AUTHORIZE_TOKEN_SECRET = "cqut";
    //JWT过期时间，单位毫秒。 7*24*60*60*1000=604800000
    private long AUTHORIZE_TOKEN_EXPIRE = 604800000;

//    public static void main(String[] args) {
//        // JWTUtil jwtUtill = new JWTUtil();
//        // String jwt = jwtUtill.createJwt(null);
//        //  System.out.println(jwt);
//        //
//        // jwtUtill.validateJWT("eyJhbGciOiJIUzI1NiJ9.eyJyb2xlIjoiQURNSU4iLCJpc3MiOiJjb20uaHF5aiIsImlkIjoiMTAwMSIsImV4cCI6MTY0ODg2NjYzMiwiaWF0IjoxNjQ4ODY2NjI3fQ.Erl0VDC9zJm-wENFbriSiTHP-jN3xBpodCFQTPskH3M");
//        //
//        //
//    }

    public String createJwt(SysUser sysUser) {
        //jwt的加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前时间戳,生成过期时间
        long nowMillis = System.currentTimeMillis();
        long expMillis = nowMillis + AUTHORIZE_TOKEN_EXPIRE;
        Date expDate = new Date(expMillis);
        //token的签发时间
        Date now = new Date(nowMillis);
        //需要保存到token字符串的有用信息
        Map<String, Object> map = new HashMap<>();
        map.put("suRole", sysUser.getSuRole());
        map.put("suId", "" + sysUser.getSuId());
        map.put("suName", sysUser.getSuName());
        JwtBuilder builder = Jwts.builder()
                .setClaims(map)  //设置附加信息
                // .setId("1")
//                .setSubject("权限验证")   // 主题
                .setIssuer("cn.edu.cqut")     // 签发者
                .setIssuedAt(now)      // 签发时间
                .signWith(signatureAlgorithm, AUTHORIZE_TOKEN_SECRET)  // 签名算法以及密匙
                .setExpiration(expDate); // 过期时间
        return builder.compact();
    }

    /**
     * 验证JWT
     * @param token
     * @return
     */

    public TableResult<Claims> validateJWT(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(AUTHORIZE_TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("token是正确的");
            return TableResult.ok("", claims);
        } catch (ExpiredJwtException e) {
            System.out.println("token过期");
            return TableResult.error(2, "token过期");
        } catch (SignatureException e) {
            System.out.println("token签名不正确");
            return TableResult.error(3, "token校验异常");
        } catch (Exception e) {
            System.out.println("其他异常");
            return TableResult.error(4, "token异常");
        }
    }
}