package alvarez.wilfredo.dynamodbmaven.mappers;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public final class DynamoDBMapperImpl {
    private static DynamoDBMapper mapper;
    public static DynamoDBMapper getClient(String region) {
        if (mapper == null) {
            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().withRegion(region).build();
            mapper = new DynamoDBMapper(client);
        }
        return mapper;
    }

    public static DynamoDBMapperConfig buildMapperConfig(String tableName) {
        return DynamoDBMapperConfig.builder()
                .withSaveBehavior(DynamoDBMapperConfig.SaveBehavior.CLOBBER)
                .withConsistentReads(DynamoDBMapperConfig.ConsistentReads.CONSISTENT)
                .withTableNameOverride(new DynamoDBMapperConfig.TableNameOverride(tableName))
                .withPaginationLoadingStrategy(DynamoDBMapperConfig.PaginationLoadingStrategy.EAGER_LOADING)
                .build();
    }
}
