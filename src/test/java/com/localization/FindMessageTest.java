package com.localization;

import com.example.satelites.Logic.FindMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class FindMessageTest {

    public static FindMessage findMessage;
    public static ArrayList<String> wordsTest;

    public static String[][] matriz = { { "este", "", "", "mensaje", "" },
                                        { "", "es", "", "", "secreto" },
                                        { "este", "", "un", "", "" }
                                         };
    
    @BeforeAll
    public static void init() {
        findMessage = new FindMessage();
        wordsTest = new ArrayList<String>();
        wordsTest.add("word1");
        wordsTest.add("word2");
        findMessage.setWords(wordsTest);
        findMessage.setMessages(matriz);
    }

    @Test
    public void validateInsertEmpty(){
        String word = "";
        findMessage.validateInsert(word);

        assertEquals(false, false);
    }

    @Test
    public void validateInsertExist(){
        String word = "word1";
        findMessage.validateInsert(word);

        assertEquals(false, false);
    }

    @Test
    public void validateInsertNotExist(){
        String word = "word3";
        findMessage.validateInsert(word);

        assertEquals(true, true);
    }

    @Test
    public void orderMessageTest(){
        String exp = "word1 word2";
        findMessage.orderMessage();
        String act = findMessage.getFinalMessage();

        assertEquals(exp, act);
    }
}

