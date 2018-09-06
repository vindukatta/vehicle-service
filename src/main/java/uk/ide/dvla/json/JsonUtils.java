package uk.ide.dvla.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by indukatta on 06/09/2018.
 */
public final class JsonUtils {
	/**
	 * convert object to string
	 */
    public static String toString(Object object) throws IOException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
