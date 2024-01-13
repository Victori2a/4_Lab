package interfaces;

import base.Item;

public interface AbleToStore {
    void setItems(Item... items);
    String getWhere();
}
