package tennis_two;

import util.Two;

/** 
 * A Contest is a general competition between two players.
 * @author Louis Tiao
 *
 */
public interface Contest
{
    /**
     * @return the two players in the current contest.
     * 
     */
    Two <Player> players ();
    
    /**
     * @param	a player currently in the contest.
     * @return	the score of the player for the current contest as an int.
     */
    int score (Player player);
    
    /**
     * @param	a player currently in the contest.
     * @return	the score of the player for the current contest as String.
     */
    String scoreAsString (Player player);
    
    /**
     * @return	<tt>true</tt> if no player has yet scored in the contest.
     */
    boolean isNew ();
    
    /**
     * @return 	<tt>true</tt> if the <tt>targetScore</tt> has been 
     * 			attained and one player has <tt>targetAdvantage</tt>
     * 			advantage over the other player.
     */
    boolean isOver ();
    
    /**
     * <b>Preconditions:</b> requires that the contest is over.
     * @return	the player who won the contest.
     *
     */
    Player winner ();
    
    /**
     * <b>Preconditions:</b> requires that the contest is over.
     * @return	the player who lost the contest.
     *
     */
    Player loser ();
    
    /**
     * @return	the server of the contest
     */
    Player server ();
    
    /**
     * @return	the receiver in the contest - complement of the server
     */
    Player receiver ();
    
    /**
     * @return	name of the contest
     */
    String getContestName ();

    
    /**
     *	Display player and corresponding score
     */
    void display ();
    
    // updates
    void play ();
    
}
