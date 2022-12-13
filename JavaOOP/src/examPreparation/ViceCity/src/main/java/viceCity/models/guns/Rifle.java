package viceCity.models.guns;

public class Rifle extends BaseGun {
   // private static int bulletPerBarrel = 50;
   // private static int totalBullet = 500;
    private static int BULLET_PER_SHOT = 5;

    public Rifle(String name) {
        super(name, 50, 450);
    }

    @Override
    public int fire() {
        this.setBulletsPerBarrel(this.getBulletsPerBarrel() - BULLET_PER_SHOT);
        this.setCanFire();
        if (getBulletsPerBarrel() == 0 && getTotalBullets() > 0){
            this.setBulletsPerBarrel(50);
            this.setTotalBullets(this.getTotalBullets() - 50);
        }
        return BULLET_PER_SHOT;
    }
}
