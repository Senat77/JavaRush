package com.javarush.task.task13.task1328;

public abstract class AbstractRobot implements Attackable, Defensable
{
    private static int hitCount;
    public String name;

    public String getName() {return name;}

    public BodyPart attack()
    {
        BodyPart attackedBodyPart = null;
        hitCount = hitCount + 1;

        if (hitCount == 1)
        {
            attackedBodyPart = BodyPart.ARM;
        }
        else if (hitCount == 2)
             {
                attackedBodyPart = BodyPart.HEAD;
             }
             else if (hitCount == 3)
                  {
                    hitCount--;
                    attackedBodyPart = BodyPart.CHEST;
                  }
                  else if (hitCount == 5)
                        {
                            hitCount = 0;
                            attackedBodyPart = BodyPart.LEG;
                        }
        return attackedBodyPart;
    }

    public BodyPart defense() {
        BodyPart defencedBodyPart = null;
        hitCount = hitCount + 2;

        if (hitCount == 1) {
            defencedBodyPart = BodyPart.HEAD;
        } else if (hitCount == 2) {
            defencedBodyPart = BodyPart.LEG;
        } else if (hitCount == 3) {
            hitCount--;
            defencedBodyPart = BodyPart.ARM;
        } else if (hitCount == 4) {
            hitCount = 0;
            defencedBodyPart = BodyPart.CHEST;
        }
        return defencedBodyPart;
    }
}
