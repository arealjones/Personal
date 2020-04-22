package DesignPatterns.Factory.cookiefactory;

public class CookieFactory {

    public static Cookie makeCookie(String name) {
        switch (name) {
            case Constants.SAMOA:
                return new SamoaCookie();
            case Constants.DOSIDOS:
                return new DosidoCookie();
            case Constants.THIN_MINTS:
                return new ThinMintCookie();
            default:
                return null;
        }
    }
}
