package group3.kino.util;

public class TokenAuthenticator {
    private static int key = 5566;

    public static boolean isTokenAuthenticated(int potentialKey) {
        if (potentialKey != key)
            return false;
        return true;
    }
}
