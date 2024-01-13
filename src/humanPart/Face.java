package humanPart;

import base.Human;
import enums.FaceType;

import java.util.Arrays;
import java.util.ArrayList;

public class Face extends BodyPart{
    protected ArrayList<FaceType> faceType = new ArrayList<>();
    public Face(String name, Human owner) {
        super(name, owner);
    }
    public void setTypes(FaceType... faceTypes){
        faceType.addAll(Arrays.asList(faceTypes));
    }
    public FaceType[] getTypes() {
        FaceType[] types1 = new FaceType[this.faceType.size()];
        return this.faceType.toArray(types1);
    }
    public boolean hasType(FaceType type) {
        return faceType.contains(type);
    }
}
