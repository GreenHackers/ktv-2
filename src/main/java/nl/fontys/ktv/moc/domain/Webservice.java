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
     * Retrieve a list of all assignments
     *
     * @return ArrayList<Assignment>
     */
    public ArrayList<Assignment> getAssignments() {
        ArrayList<Assignment> assignments = new ArrayList<>();

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

    /**
     * Retrieve a list of alle competitions
     *
     * @return ArrayList<Competition>
     */
    public ArrayList<Competition> getCompetitions() {
        ArrayList<Competition> competitions = new ArrayList<>();

        // Make api call
        String jsonString = api.call("/competitions", IApi.httpRequestType.GET);

        // Loop trough the items
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            // Get object (item)
            JSONObject objects = jsonArray.getJSONObject(i);

            //System.out.println(objects);
            // id, title, description, teams[], rounds[]
            // Create competition
            Competition competition = new Competition();
            competition.setTitle(objects.get("title").toString());
            competition.setDescription(objects.get("description").toString());
            competition.setApiId(objects.get("id").toString());

            // Loop trough teams and add them to the competition
            JSONArray teams = new JSONArray(objects.get("teams").toString());
            for (int t = 0; t < teams.length(); t++) {
                JSONObject jsonTeam = teams.getJSONObject(t);
                //System.out.println(jsonHint);

                // @TODO, niet gebruikte variabelen uit de JSON: node:null, username, password, fullname, role
                Team team = new Team();
                team.setName(jsonTeam.get("teamname").toString());
                team.setEmail(jsonTeam.get("email").toString());
                team.setTotalscore(Integer.parseInt(jsonTeam.get("totalscore").toString()));
                team.setApiId(jsonTeam.get("id").toString());

                // Process team members
                // Loop trough team members and add them to the team
                JSONArray members = new JSONArray(jsonTeam.get("members").toString());
                for (int m = 0; m < members.length(); m++) {
                    JSONObject jsonMember = members.getJSONObject(m);

                    Member member = new Member(jsonMember.get("membername").toString(), jsonMember.get("email").toString(), team);
                    member.setApiId(jsonMember.get("id").toString());

                    team.addMember(member);
                }

                competition.addTeam(team);
            }

            // Loop trough rounds and add them to the competition
            JSONArray rounds = new JSONArray(objects.get("rounds").toString());
            for (int r = 0; r < rounds.length(); r++) {
                JSONObject jsonRound = rounds.getJSONObject(r);
                //System.out.println(jsonHint);

                Round round = new Round();
                round.setCompetition(competition);
                round.setDuration(Integer.parseInt(jsonRound.get("duration").toString()));
                round.setMultiplier(Integer.parseInt(jsonRound.get("multiplier").toString()));
                round.setApiId(jsonRound.get("id").toString());

                JSONObject jsonAssignment = jsonRound.getJSONObject("assignment");

                // Set assignment on this round
                Assignment assignment = new Assignment();

                // Set data on assignment
                assignment.setArtifact(jsonAssignment.get("artifact").toString());
                assignment.setName(jsonAssignment.get("name").toString());
                assignment.setParticipantDescription(jsonAssignment.get("participantDescription").toString());
                assignment.setCreatorName(jsonAssignment.get("creatorName").toString());
                assignment.setCreatorOrganisation(jsonAssignment.get("creatorOrganisation").toString());
                assignment.setCreatorLink(jsonAssignment.get("creatorLink").toString());
                assignment.setApiId(jsonAssignment.get("id").toString());

                // Process hints
                // Loop trough rounds and add them to the competition
                JSONArray hints = new JSONArray(jsonAssignment.get("hints").toString());
                for (int h = 0; h < hints.length(); h++) {
                    JSONObject jsonHint = hints.getJSONObject(h);

                    Hint hint = new Hint();
                    hint.setAssigment(assignment); // @TODO, is deze niet dubbelop?
                    hint.setText(jsonHint.get("text").toString());
                    hint.setTime(Integer.parseInt(jsonHint.get("time").toString()));
                    hint.setApiId(jsonHint.get("id").toString());

                    assignment.addHint(hint);
                }

                round.setAssignment(assignment);

                competition.addRound(round);
            }

            competitions.add(competition);
        }

        return competitions;
    }

    /**
     * Retrieve a list of all scores
     *
     * @return ArrayList<Score>
     */
    public ArrayList<Score> getScores() {
        ArrayList<Score> scores = new ArrayList<>();

        // Make api call
        String jsonString = api.call("/scores", IApi.httpRequestType.GET);

        // Loop trough the items
        JSONArray jsonScores = new JSONArray(jsonString);
        for (int s = 0; s < jsonScores.length(); s++) {
            // Get object (item)
            JSONObject jsonScore = jsonScores.getJSONObject(s);

            //System.out.println(objects);
            // Create score
            Score score = new Score();

            // Set data on score
            score.setScore(Integer.parseInt(jsonScore.get("score").toString()));
            score.setApiId(jsonScore.get("id").toString());

            JSONObject jsonTeam = jsonScore.getJSONObject("user");

            Team team = new Team();
            team.setName(jsonTeam.get("teamname").toString());
            team.setEmail(jsonTeam.get("email").toString());
            team.setTotalscore(Integer.parseInt(jsonTeam.get("totalscore").toString()));
            team.setApiId(jsonTeam.get("id").toString());

            // Process team members
            // Loop trough team members and add them to the team
            JSONArray members = new JSONArray(jsonTeam.get("members").toString());
            for (int m = 0; m < members.length(); m++) {
                JSONObject jsonMember = members.getJSONObject(m);

                Member member = new Member(jsonMember.get("membername").toString(), jsonMember.get("email").toString(), team);
                member.setApiId(jsonMember.get("id").toString());

                team.addMember(member);
            }

            score.setTeam(team);

            JSONObject jsonRound = jsonScore.getJSONObject("round");
            Round round = new Round();

            // Create competition @TODO title and description are missing at this point.
            Competition competition = new Competition();
            competition.setApiId(jsonRound.get("competition").toString());
            round.setCompetition(competition);

            round.setDuration(Integer.parseInt(jsonRound.get("duration").toString()));
            round.setMultiplier(Integer.parseInt(jsonRound.get("multiplier").toString()));
            round.setApiId(jsonRound.get("id").toString());

            JSONObject jsonAssignment = jsonRound.getJSONObject("assignment");

            // Set assignment on this round
            Assignment assignment = new Assignment();

            // Set data on assignment
            assignment.setArtifact(jsonAssignment.get("artifact").toString());
            assignment.setName(jsonAssignment.get("name").toString());
            assignment.setParticipantDescription(jsonAssignment.get("participantDescription").toString());
            assignment.setCreatorName(jsonAssignment.get("creatorName").toString());
            assignment.setCreatorOrganisation(jsonAssignment.get("creatorOrganisation").toString());
            assignment.setCreatorLink(jsonAssignment.get("creatorLink").toString());
            assignment.setApiId(jsonAssignment.get("id").toString());

                // Process hints
            // Loop trough rounds and add them to the competition
            JSONArray hints = new JSONArray(jsonAssignment.get("hints").toString());
            for (int h = 0; h < hints.length(); h++) {
                JSONObject jsonHint = hints.getJSONObject(h);

                Hint hint = new Hint();
                hint.setAssigment(assignment); // @TODO, is deze niet dubbelop?
                hint.setText(jsonHint.get("text").toString());
                hint.setTime(Integer.parseInt(jsonHint.get("time").toString()));
                hint.setApiId(jsonHint.get("id").toString());

                assignment.addHint(hint);
            }

            round.setAssignment(assignment);
            
            score.setRound(round);

            scores.add(score);
        }

        return scores;
    }

}
