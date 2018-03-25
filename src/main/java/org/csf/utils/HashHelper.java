package org.csf.utils;


import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

/**
 * @author Andrew Boytsov
 * @date 25.03.2018
 */

public final class HashHelper {

    public static String encodeSha256(String object) {
        return !StringUtils.isEmpty(object) ? DigestUtils.sha256Hex(object) : null;
    }

}
