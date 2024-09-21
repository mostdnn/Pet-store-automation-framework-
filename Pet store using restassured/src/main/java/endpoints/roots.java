package endpoints;




public class roots {


    // users roots

    public static String basUrl="https://petstore.swagger.io/v2";
    // User module
    public static String posturl=basUrl+"/user";
    public static String geturl=basUrl+"/user/{username}";
    public static String updateUrl=basUrl+"/user/{username}";
    public static String deleteUrl=basUrl+"/user/{username}";
    public static String loginURL=basUrl+"/user/login";
    public static String logoutURL=basUrl+"/user/logout";
    public static String createuserlistarrayURL=basUrl+"/user/createWithArray";

    // pets roots
    public static String uploadimageURL=basUrl+"/pet/{petId}/uploadImage";
    public static String addpetURL=basUrl+"/pet";
    public static String updatepetURL=basUrl+"/pet";
    public static String updatepetpetURL=basUrl+"/pet";
    public static String findpetbystatusURL=basUrl+"/pet/findByStatus";
    public static String findpetbyidURL=basUrl+"/pet/{petId}";
    public static String updatepetwithformdataURL=basUrl+"/pet/{petId}";
    public static String deletepetURL=basUrl+"/pet/{petId}";
// store roots
    public static String placeanorderURL=basUrl+"/store/order";
    public static String findorderbyidURL =basUrl+"/store/order/{orderId}";
    public static String deleteorderURL=basUrl+"/store/order/{orderId}";
    public static String returnstatusURL=basUrl+"/store/inventory";


}
