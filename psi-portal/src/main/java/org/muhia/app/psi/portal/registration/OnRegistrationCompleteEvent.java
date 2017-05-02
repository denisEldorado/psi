package org.muhia.app.psi.portal.registration;


import org.muhia.app.psi.orm.model.Principals;
import org.springframework.context.ApplicationEvent;
/**
 *Creates a registration log on first time use
 * 
 */
public class OnRegistrationCompleteEvent extends ApplicationEvent {
/**
	 * 
	 */
	private static final long serialVersionUID = -4773686074279090357L;
/**
 * Gets the application web url
 *
 */
    private final String appUrl;
    private final Principals user;

    public OnRegistrationCompleteEvent(final Principals user, final String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }

    //
/**
 * 
 * @return appurl - gets the url acquired from the user input
 * 
 */
    public String getAppUrl() {
        return appUrl;
    }

    public Principals getUser() {
        return user;
    }

}
