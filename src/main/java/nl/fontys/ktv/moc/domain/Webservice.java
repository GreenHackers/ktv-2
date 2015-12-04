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

    public Assignment createAssignment(Assignment assignment) {
        // @TODO create, set id  and return new object
        // use getAssignment();
        return assignment;
    }

    public Assignment updateAssignment(Assignment assignment) {
        // @TODO update and return new object
        // use getAssignment();
        return assignment;
    }

    public Assignment getAssignment(int id) {
        // @TODO retrieve object from webservice
        return new Assignment();
    }

    public boolean deleteAssignment(int id) {
        // @TODO delete
        return true;
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

    public Competition createCompetition(Competition competition) {
        // @TODO create, set id  and return new object
        // use getCompetition();
        return competition;
    }

    public Competition updateCompetition(Competition competition) {
        // @TODO update and return new object
        // use getCompetition();
        return competition;
    }

    public Competition getCompetition(int id) {
        // @TODO retrieve object from webservice
        return new Competition();
    }

    public boolean deleteCompetition(int id) {
        // @TODO delete
        return true;
    }

    public Competition getCurrentCompetition() {
        return new Competition();
    }

    public boolean startCompetition(Competition competition) {
        return true;
    }

    public boolean stopCompetition() {
        return true;
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

    public Score createScore(Score score) {
        // @TODO create, set id  and return new object
        // use getScore();
        return score;
    }

    public Score updateScore(Score score) {
        // @TODO update and return new object
        // use getScore();
        return score;
    }

    public Score getScore(int id) {
        // @TODO retrieve object from webservice
        return new Score();
    }

    public boolean deleteScore(int id) {
        // @TODO delete
        return true;
    }

    /**
     * Retrieve a list of all rounds
     *
     * @return ArrayList<Round>
     */
    public ArrayList<Round> getRounds() {
        ArrayList<Round> rounds = new ArrayList<>();

        // Make api call
        String jsonString = api.call("/rounds", IApi.httpRequestType.GET);

        // Loop trough the items
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            // Get object (item)
            JSONObject jsonRound = jsonArray.getJSONObject(i);

            //System.out.println(objects);
            // Create round
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

            rounds.add(round);
        }

        return rounds;
    }

    public Round createRound(Round round) {
        // @TODO create, set id  and return new object
        // use getRound();
        return round;
    }

    public Round updateRound(Round round) {
        // @TODO update and return new object
        // use getRound();
        return round;
    }

    public Round getRound(int id) {
        // @TODO retrieve object from webservice
        return new Round();
    }

    public boolean deleteRound(int id) {
        // @TODO delete
        return true;
    }

    /**
     * Retrieve a list of all users
     *
     * @return ArrayList<User>
     */
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        // Make api call
        String jsonString = api.call("/users", IApi.httpRequestType.GET);

        // Loop trough the items
        JSONArray jsonArray = new JSONArray(jsonString);
        for (int i = 0; i < jsonArray.length(); i++) {
            // Get object (item)
            JSONObject jsonUser = jsonArray.getJSONObject(i);

            // Create user
            User user = new User();
            user.setUserName(jsonUser.get("username").toString());
            user.setPassword(jsonUser.get("password").toString());
            user.setFullName(jsonUser.get("fullname").toString());
            user.setTeamName(jsonUser.get("teamname").toString());
            user.setEmail(jsonUser.get("email").toString());

            switch (jsonUser.get("role").toString()) {
                case "admin":
                    user.setRole(UserRole.ADMIN);
                    break;
                case "guest":
                    user.setRole(UserRole.GUEST);
                    break;
                case "user":
                    user.setRole(UserRole.USER);
                    break;
            }
            user.setApiId(jsonUser.get("id").toString());

            users.add(user);
        }

        return users;
    }

    public User createUser(User user) {
        // @TODO create, set id  and return new object
        // use getUser();
        return user;
    }

    public User updateUser(User user) {
        // @TODO update and return new object
        // use getUser();
        return user;
    }

    public User getUser(int id) {
        // @TODO retrieve object from webservice
        return new User();
    }

    public boolean deleteUser(int id) {
        // @TODO delete
        return true;
    }

    /**
     * Retrieve the current user
     *
     * @return ArrayList<User>
     */
    public User getCurrentUser() {
        // Make api call
        String jsonString = api.call("/users/current", IApi.httpRequestType.GET);

        JSONObject jsonUser = new JSONObject(jsonString);

        // Create user
        User user = new User();
        user.setUserName(jsonUser.get("username").toString());
        user.setPassword(jsonUser.get("password").toString());
        user.setFullName(jsonUser.get("fullname").toString());
        user.setTeamName(jsonUser.get("teamname").toString());
        user.setEmail(jsonUser.get("email").toString());

        switch (jsonUser.get("role").toString()) {
            case "admin":
                user.setRole(UserRole.ADMIN);
                break;
            case "guest":
                user.setRole(UserRole.GUEST);
                break;
            case "user":
                user.setRole(UserRole.USER);
                break;
        }
        user.setApiId(jsonUser.get("id").toString());

        return user;

    }

    public ArrayList<Team> getTeams() {

        ArrayList<Team> teams = new ArrayList<>();
        for (User user : this.getUsers()) {
            if (user.getTeamName().length() > 0) {
                boolean isNew = true;
                for (Team t : teams) {
                    if (t.getName().equals(user.getTeamName())) {
                        isNew = true;
                    }
                }
                if (isNew == true) {
                    Team team = new Team();
                    team.setName(user.getTeamName());

                    teams.add(team);
                }
            }

        }

        return teams;
    }

    public Team createTeam(Team hint) {
        // @TODO create, set id  and return new object
        // use getTeam();
        return hint;
    }

    public Team updateTeam(Team hint) {
        // @TODO update and return new object
        // use getTeam();
        return hint;
    }

    public Team getTeam(int id) {
        // @TODO retrieve object from webservice
        return new Team();
    }

    public boolean deleteTeam(int id) {
        // @TODO delete
        return true;
    }

    public Team getCurrentTeam() {
        User currentUser = getCurrentUser();
        if (currentUser.getRole() == UserRole.USER) {
            for (Team team : getTeams()) {
                if (team.getName().equals(currentUser.getTeamName())) {
                    return team;
                }
            }
        }
        return null;
    }

    public ArrayList<Hint> getHints() {
        ArrayList<Hint> hints = new ArrayList<>();

        return hints;
    }

    public Hint createHint(Hint hint) {
        // @TODO create, set id  and return new object
        // use getHint();
        return hint;
    }

    public Hint updateHint(Hint hint) {
        // @TODO update and return new object
        // use getHint();
        return hint;
    }

    public Hint getHint(int id) {
        // @TODO retrieve object from webservice
        return new Hint();
    }

    public boolean deleteHint(int id) {
        // @TODO delete
        return true;
    }

    public boolean login(String username, String password) {
        return true;
    }

    public boolean loginAsGuest() {
        return true;
    }

    public boolean logout() {
        return true;
    }
}
