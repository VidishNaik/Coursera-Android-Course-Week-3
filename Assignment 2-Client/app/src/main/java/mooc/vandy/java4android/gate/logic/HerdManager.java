package mooc.vandy.java4android.gate.logic;

import android.util.Log;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    private static final int HERD = 24;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    // TODO -- Fill your code in here

    public void simulateHerd(Random rand)
    {
        int in = HERD;
        int out = 0;
        int temp;
        int no;
        for (int i=0;i<=MAX_ITERATIONS;i++)
        {
            mOut.println("There are currently "+in+" snails in the pen and "+out+" snails in the pasture");
            if(out == 0)
                no = 0;
            else if (in == 0)
                no = 1;
            else
                no = rand.nextInt(2);
            switch (no)
            {
                case 0:
                    temp = rand.nextInt(in);
                    mEastGate.thru(temp);
                    out = out + temp;
                    in = in - temp;
                    break;
                case 1:
                    temp = rand.nextInt(out);
                    mWestGate.thru(temp);
                    out = out - temp;
                    in = in + temp;
                    break;
            }
            Log.d("HerdManager","IN "+in+" OUT "+out);
        }
    }

}
