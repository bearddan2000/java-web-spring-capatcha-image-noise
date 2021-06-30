package example.capatcha;

public class CapatchaText {

  public static String generate()
  {

      // chose a Character random from this String
      String AlphaString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

      // create StringBuffer size of AlphaNumericString
      StringBuilder sb = new StringBuilder(5);

      for (int i = 0; i < 5; i++) {

          // generate a random number between
          // 0 to AlphaNumericString variable length
          int index
              = (int)(AlphaString.length()
                      * Math.random());

          // add Character one by one in end of sb
          sb.append(AlphaString
                        .charAt(index));
      }

      return sb.toString();
  }

}
