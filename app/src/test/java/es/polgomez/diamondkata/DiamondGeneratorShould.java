package es.polgomez.diamondkata;

import junit.framework.Assert;

import org.junit.Test;

public class DiamondGeneratorShould {
    
    @Test
    public void given_a_returns_a() {
        Assert.assertEquals(DiamondGenerator.generate('A')[0], "A");
    }
    @Test
    public void given_z_returns_51_mid_spaces() {
        Assert.assertEquals(DiamondGenerator.generate('Z')[25], "Z                                                 Z");
    }

    @Test
    public void given_b_returns_bb() {
        String[] result = DiamondGenerator.generate('B');
        Assert.assertEquals(result[1], "B B");
    }

    @Test
    public void given_b_returns_top_whitespace_A() {
        String[] result = DiamondGenerator.generate('B');
        Assert.assertEquals(result[0], " A ");
    }

    @Test
    public void given_b_finish_with_a() {
        String[] result = DiamondGenerator.generate('B');
        Assert.assertEquals(result[2], " A ");
    }

    @Test
    public void given_c_middle_contains_c_three_spaces_c() {
        String[] result = DiamondGenerator.generate('C');
        Assert.assertEquals(result[2], "C   C");
    }

    @Test
    public void given_c_has_previous_A_BB() {
        String[] result = DiamondGenerator.generate('C');
        Assert.assertEquals(result[2], "C   C");
    }

    static class DiamondGenerator {

        public static String[] generate(char letter) {
            if (letter == 'A') {
                return new String[]{"A"};
            } else {
                int dimension = (((letter - 64) * 2) - 1);
                String[] result = new String[dimension];

                int middle = letter - 65;
                for (int i = 0; i < dimension; i++) {
                    String row = null;
                    if (i < middle) {
                        char rowChar = (char) (i + 65);
                        String spaces = "";
                        int numberSpaces = middle - i;
                        for (int j = 0; j < numberSpaces; j++) {
                            spaces += " ";
                        }

                        row = spaces + rowChar;
                        if (i >= 1) {
                            int middSpaces = i * 2 - 1;
                            for (int j = 0; j < middSpaces; j++) {
                                row += " ";
                            }
                            row += rowChar + spaces;
                        } else {
                            row += spaces;
                        }
                    } else if (i == middle) {
                        char rowChar = (char) (i + 65);
                        row = "" + rowChar;
                        int middSpaces = i * 2 - 1;
                        for (int j = 0; j < middSpaces; j++) {
                            row += " ";
                        }
                        row += "" + rowChar;

                    }

                    result[i] = row;
                }

                for (int i = 0; i < middle; i++) {
                    String s = result[i];
                    result[result.length - 1 - i] = s;
                }

                return result;
            }

        }

    }
}