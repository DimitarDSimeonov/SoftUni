package viceCity.models.guns;

public class Pistol extends BaseGun {
    //private static int bulletPerBarrel = 10;
   // private static int totalBullet = 100;
    private static final int BULLET_PER_SHOT = 1;

    public Pistol(String name) {
        super(name, 10, 90);
    }

    @Override
    public int fire() {
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - BULLET_PER_SHOT);
        this.setCanFire();
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0){
            this.setBulletsPerBarrel(10);
            this.setTotalBullets(this.getTotalBullets() - 10);
        }
        return BULLET_PER_SHOT;
    }
}
