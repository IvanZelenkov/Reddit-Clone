package com.clone.reddit.redditclone.model;

import com.clone.reddit.redditclone.exceptions.SpringRedditException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("VoteType Enum Test")
public class VoteTypeTest {

    /**
     * Tests that the lookup() method returns VoteType.UPVOTE when called with the value 1.
     */
    @Test
    public void testLookupUpVote() {
        VoteType voteType = VoteType.lookup(1);
        assertEquals(VoteType.UPVOTE, voteType);
    }

    /**
     * Tests that the lookup() method returns VoteType.DOWNVOTE when called with the value -1.
     */
    @Test
    public void testLookupDownVote() {
        VoteType voteType = VoteType.lookup(-1);
        assertEquals(VoteType.DOWNVOTE, voteType);
    }

    /**
     * Tests that the lookup() method throws a SpringRedditException with the message "Vote not found"
     * when called with an invalid value (e.g. 0). The assertThrows() method is used to assert that
     * the exception is thrown, and the getMessage() method is used to retrieve the actual error message.
     * The assertTrue() method is used to check that the actual message contains the expected message.
     */
    @Test
    public void testLookupInvalid() {
        Exception exception = assertThrows(SpringRedditException.class, () -> {
            VoteType.lookup(0);
        });

        String expectedMessage = "Vote not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
