package logic;

/**
 *
 * @author Vics
 */
public interface ControllerInterface {

    /**
     *
     * @return antallet af både aktive og inaktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfMembers() throws Exception;

    /**
     *
     * @return antallet af aktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfActiveMembers() throws Exception;

    /**
     *
     * @return antallet af inaktive member's
     * @throws java.lang.Exception
     */
    public int getTotalNumberOfNotActiveMembers() throws Exception;

    /**
     *
     * @return checker om en String er en email. F.eks. string indeholder @ og
     * .dk
     * @throws java.lang.Exception
     */
    public boolean checkEmail(String email) throws Exception;

}
