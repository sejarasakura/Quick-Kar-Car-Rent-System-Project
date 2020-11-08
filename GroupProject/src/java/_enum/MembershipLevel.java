package _enum;
//<editor-fold defaultstate="collapsed" desc="Imported documents.">
import java.util.Arrays;

//</editor-fold>
public enum MembershipLevel {
    //<editor-fold defaultstate="collapsed" desc="Lim sai keat hide all...">
    //<editor-fold defaultstate="collapsed" desc="Enumerator(MembershipLevel) list">
    /*Example  (code, seq_code/power, name, decription)*/
    BRONZE      ("BR", 0, "Bronze", "Bronze membership is all the defualt registered customer.", 0),
    SILVER        ("SI", 1, "Silver",  "Silver membershiip is all the normal paid member", 0.08),
    GOLD          ("AU", 2, "Gold",  "Gold membership is the paid member with VIP class", 0.20),
    PLATINIUM ("PL", 3, "Platinium", "Platinium member is the member that VVIP for specific person only", 0.50);
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Enumerator(MembershipLevel) properties">
    private final String code;
    private final int seq_code;
    private final String name;
    private final String description;
    private final double discount;
    private MembershipLevel(String code, int seq_code, String name, String description, double discount) {
        this.code = code;
        this.seq_code = seq_code;
        this.name = name;
        this.description = description;
        this.discount = discount;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Enumerator(MembershipLevel) Getter">
    public String getDatabaseCode() {
        return code;
    }
    
    public double getDiscount(){
        return discount;
    }

    public int getSequenceCode() {
        return seq_code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Enumerator(MembershipLevel) Convertor">
    public static int length(){
        return 4;
    }
     public static MembershipLevel getValue(String string) {
        //Membership defualt value BRONZE;
        try {
            if(Arrays.asList(PLATINIUM.code.toLowerCase(), 
                    PLATINIUM.name.toLowerCase(), (PLATINIUM.seq_code + "").toLowerCase()).contains(string.toLowerCase())){
                return MembershipLevel.PLATINIUM;
            } else if(Arrays.asList(SILVER.code.toLowerCase(),"sl", 
                    SILVER.name.toLowerCase(), (SILVER.seq_code + "").toLowerCase()).contains(string.toLowerCase())){
                return MembershipLevel.SILVER;
            } else if(Arrays.asList(GOLD.code.toLowerCase(), 
                    GOLD.name.toLowerCase(), (GOLD.seq_code + "").toLowerCase()).contains(string.toLowerCase())){
                return MembershipLevel.GOLD;
            } else if(Arrays.asList(BRONZE.code.toLowerCase(), 
                    BRONZE.name.toLowerCase(), (BRONZE.seq_code + "").toLowerCase()).contains(string.toLowerCase())){
                return MembershipLevel.BRONZE;
            } else {
                try {return valueOf(string.toUpperCase());} catch (Exception ex) {return null;}
            }
        } catch (Exception e) {
                try {
                return MembershipLevel.valueOf(string.toUpperCase());
            } catch (Exception ex) {
                return null;
            }
        }
    }
     public static MembershipLevel getValue(Object member_level){
         if(member_level instanceof MembershipLevel)
            return (MembershipLevel)member_level;
        else if(member_level instanceof String)
            return MembershipLevel.getValue((String)member_level);
        else{
            return null;
        }
     }
    //</editor-fold>
     
     public static void main(String[] args){
         System.out.println(MembershipLevel.getValue("AU"));
     }
    //</editor-fold>
}
