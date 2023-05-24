import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class CalenderAPI {
    private static final String BASE_URL = "http://calapi.inadiutorium.cz/api/v0/en/calendars/default/";
    public static Calender getCalender(int year, int month) {
        String url = BASE_URL + year + "/" + month;
        String urlResponse = "";
        try {
            URI myUri = URI.create(url);
            HttpRequest request = HttpRequest.newBuilder().uri(myUri).build();
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            urlResponse = response.body();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Month dayList = new Month();
        JSONArray objArr = new JSONArray(urlResponse);
        System.out.println(objArr);
        for (int i = 0; i < objArr.length(); i++) {
            JSONObject obj = objArr.getJSONObject(i);
            String date = obj.getString("date");
            String[] converted = Dates.convertISO(date); //collect the date string
            String tempMon = Dates.convertToName(Integer.parseInt(converted[0])); //use dates to convert monthNUm to its name
            int tempDay = Integer.parseInt(converted[1]);
            int tempYear = Integer.parseInt(converted[2]);
            dayList.addDay(new Day(tempMon, tempDay, tempYear, obj.getString("weekday")));
        }


        return new Calender(dayList, dayList.getDay(0).getMonth()); //might wnat to pass it in as all caps?

    }



}
