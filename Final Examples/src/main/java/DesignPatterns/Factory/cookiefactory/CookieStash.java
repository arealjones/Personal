package DesignPatterns.Factory.cookiefactory;

import java.util.HashMap;
import java.util.Map;

public class CookieStash {
    Map<Cookie, Integer> stash;

    public CookieStash(Map<String, Integer> cookies) throws InvalidArgumentsException {
        this.stash = new HashMap<>();
        this.fillStash(cookies);
    }

    private void fillStash(Map<String, Integer> cookies) throws InvalidArgumentsException {
        for (String name: cookies.keySet()) {
            if (name == null)
                throw new InvalidArgumentsException("Unknown cookie name!");
            this.stash.put(CookieFactory.makeCookie(name), cookies.get(name));
        }
    }

    public Map<Cookie, Integer> getStash() {
        return this.stash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cookie stash:").append(System.lineSeparator());
        if (this.stash.size() == 0)
            sb.append("You have no cookies :(");
        for (Cookie cookie: this.stash.keySet()) {
            sb.append(this.stash.get(cookie)).append(" ").append(cookie.getName()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
