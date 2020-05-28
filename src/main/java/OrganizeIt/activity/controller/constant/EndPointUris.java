package OrganizeIt.activity.controller.constant;


public final class EndPointUris {
    public static final String API = "/api";
    public static final String V1 = "/v1";

    public static final String NEW   = "/new";
    public static final String IMG   = "/img";
    public static final String GET   = "/{title}";
    public static final String ADDUser   = "/addUser";
    public static final String RemoveUser   = "/removeUser";
    public static final String ADDPlace   = "/addPlace";
    public static final String ADDDate   = "/addDate";
    public static final String GetById   = "/id/{id}";


    public static final String DeleteById = "/delete/{id}";

    public static final String DenieInvitation = "/denie/{id}/{name}";

    public static final String GetByUserInvited   = "/invited/{email}";
    public static final String GetByUserIsCreator   = "/creator/{email}";
    public static final String GetByUserAssists   = "/assists/{email}";


}
