package Trans;
import java.util.List;

import com.google.api.services.translate.Translate;
import com.google.api.services.translate.model.TranslationsListResponse;

public class Trans {

    public static String tranlateToCn(List<String> ls){
        try {
            // See comments on
            //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
            // on options to set
            Translate t = new Translate.Builder(
                    com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport()
                    , com.google.api.client.json.gson.GsonFactory.getDefaultInstance(), null)
                    //Need to update this to your App-Name
                    .setApplicationName("translatetable-1361")
                    .build();
            Translate.Translations.List list = t.new Translations().list(
                    ls,
                    //Target language
                    "zh-CN");
            //Set your API-Key from https://console.developers.google.com/
            list.setKey("AIzaSyBMhnuBS6r9neiauTNoFQO0kMXp3fCV0jQ");
            TranslationsListResponse response = list.execute();
            return response.getTranslations().get(0).getTranslatedText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}