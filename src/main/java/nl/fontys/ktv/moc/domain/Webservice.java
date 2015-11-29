/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.fontys.ktv.moc.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import nl.fontys.ktv.moc.stub.ApiStub;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class makes requests to IApi and converts the results (JSON) to usable
 * objects.
 *
 * @author Jeroen van Gijzel <jeroenvangijzel@gmail.com>
 */
public class Webservice {

    private IApi api;

    public Webservice() {
        // Create new api client
        //api = new Api(); // Make use of the LIVE webservice API
        api = new ApiStub(); // Make use of the STUBBED webservice API
    }

    /**
     * Retrieve a list of alle assignments
     *
     * API documentation: -------------------------------------------- Makes use
     * of: Service: AssignmentService Type: GET URL: /assignments Result:
     * Returns a List with all assignments.
     *
     * @return ArrayList<Assignment>
     */
    public ArrayList<Assignment> getAssignments() {
        ArrayList<Assignment> assignments = new ArrayList<Assignment>();

        // Make api call
        String jsonString = api.call("/assignments", IApi.httpRequestType.GET);

        // Loop trough the items
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            // Get object (item)
            JSONObject objects = jsonArray.getJSONObject(i);

            //System.out.println(objects);
            // Create assignment
            Assignment assignment = new Assignment();

            // Set data on assignment
            assignment.setArtifact(objects.get("artifact").toString());
            assignment.setName(objects.get("name").toString());
            assignment.setParticipantDescription(objects.get("participantDescription").toString());
            assignment.setCreatorName(objects.get("creatorName").toString());
            assignment.setCreatorOrganisation(objects.get("creatorOrganisation").toString());
            assignment.setCreatorLink(objects.get("creatorLink").toString());
            assignment.setApiId(objects.get("id").toString());

            // Loop trough hints and add them to the assignment
            JSONArray hints = new JSONArray(objects.get("hints").toString());
            for (int h = 0; h < hints.length(); h++) {
                JSONObject jsonHint = hints.getJSONObject(h);
                //System.out.println(jsonHint);

                Hint hint = new Hint();
                hint.setAssigment(assignment); // @TODO, is deze niet dubbelop?
                hint.setText(jsonHint.get("text").toString());
                hint.setTime(Integer.parseInt(jsonHint.get("time").toString()));
                hint.setApiId(jsonHint.get("id").toString());

                assignment.addHint(hint);
            }

            assignments.add(assignment);
        }

        return assignments;
    }
}
