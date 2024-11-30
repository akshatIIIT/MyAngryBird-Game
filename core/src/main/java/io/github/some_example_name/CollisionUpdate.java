package io.github.some_example_name;
import com.badlogic.gdx.physics.box2d.*;
import java.util.ArrayList;
import static io.github.some_example_name.LevelHandler.every;
import static io.github.some_example_name.LevelHandler.score;


public class CollisionUpdate implements ContactListener {
    Species BA;
    Species BB;
    @Override
    public void beginContact(Contact contact) {

    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {
        Body ba=contact.getFixtureA().getBody();
        Body bb=contact.getFixtureB().getBody();
        BA=getSpecies(ba);
        BB=getSpecies(bb);
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {
        float im=0;
        float DamageThreshold=0.3f;
        float DamageScaleThreshold=1f;
        for(float impulse:contactImpulse.getNormalImpulses()){
            im+=Math.abs(impulse);
        }
        for(float Impulse: contactImpulse.getTangentImpulses()){
            im=Math.abs(Impulse);
        }
        float DamageAmount=Math.max(0,(im-DamageThreshold)*DamageScaleThreshold);
        //System.out.println(DamageAmount);
        //float DamageAmount = Math.min(-1, 20);
        int health = (int) DamageAmount;
        if(health>0){
            if(BA!=null && !(BA instanceof Birds)){
                BA.health-=health*10;
                int number = Integer.parseInt(score);
                number+=health;
                score=String.valueOf(number);
            }
            if(BB!= null && !(BB instanceof Birds)){
                BB.health-=health*10;
                int number = Integer.parseInt(score);
                number+=health;
                score=String.valueOf(number);

            }
        }

    }
    public Species getSpecies(Body body){
        for(Species spc:every){
            if(spc.body.equals(body)){
                return spc;
            }
        }
        return null;
    };

}
