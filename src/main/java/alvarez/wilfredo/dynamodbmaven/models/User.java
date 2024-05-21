package alvarez.wilfredo.dynamodbmaven.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

@DynamoDBTable(tableName = "users")
public class User {
    private UUID id;
    private String name;

    @DynamoDBHashKey(attributeName="id")
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    @DynamoDBAttribute(attributeName="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
