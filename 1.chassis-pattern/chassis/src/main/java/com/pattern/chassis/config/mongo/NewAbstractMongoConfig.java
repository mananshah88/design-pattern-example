package com.pattern.chassis.config.mongo;

import java.util.concurrent.TimeUnit;

import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
//import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterSettings;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.connection.ServerSettings;
import com.mongodb.connection.SocketSettings;

public abstract class NewAbstractMongoConfig {

	/* maxSize: default size is 100 */
	private int maxSize = 100;

	/* minSize: default size is 0 */
	private int minSize = 15;

	/* maxWaitTime: default is 2 Minute */
	private long maxWaitTime = 120000;

	/* maxConnectionLifeTime: there is no default value. So setting 0 */
	private long maxConnectionLifeTime = 0;

	/* maxConnectionIdleTime: there is no default value. So setting 0 */
	private long maxConnectionIdleTime = 0;

	/* minHeartbeatFrequency: default is 500 ms */
	private long minHeartbeatFrequency = 500;

	/* heartbeatFrequency: default is 10 seconds */
	private long heartbeatFrequency = 10000;

	/* connectTimeout: default is 10 seconds */
	private int connectTimeout = 10000;

	/* socketTimeout: no default value */
	private int socketTimeout = 30000;

	/* serverSelectionTimeout: default value is 30 seconds */
	private long serverSelectionTimeout = 30000;

	/* localThreshold: default value is 15 ms */
	private long localThreshold = 15;

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMinSize() {
		return minSize;
	}

	public void setMinSize(int minSize) {
		this.minSize = minSize;
	}

	public long getMaxWaitTime() {
		return maxWaitTime;
	}

	public void setMaxWaitTime(long maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public long getMaxConnectionLifeTime() {
		return maxConnectionLifeTime;
	}

	public void setMaxConnectionLifeTime(long maxConnectionLifeTime) {
		this.maxConnectionLifeTime = maxConnectionLifeTime;
	}

	public long getMaxConnectionIdleTime() {
		return maxConnectionIdleTime;
	}

	public void setMaxConnectionIdleTime(long maxConnectionIdleTime) {
		this.maxConnectionIdleTime = maxConnectionIdleTime;
	}

	public long getMinHeartbeatFrequency() {
		return minHeartbeatFrequency;
	}

	public void setMinHeartbeatFrequency(long minHeartbeatFrequency) {
		this.minHeartbeatFrequency = minHeartbeatFrequency;
	}

	public long getHeartbeatFrequency() {
		return heartbeatFrequency;
	}

	public void setHeartbeatFrequency(long heartbeatFrequency) {
		this.heartbeatFrequency = heartbeatFrequency;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public long getServerSelectionTimeout() {
		return serverSelectionTimeout;
	}

	public void setServerSelectionTimeout(long serverSelectionTimeout) {
		this.serverSelectionTimeout = serverSelectionTimeout;
	}

	public long getLocalThreshold() {
		return localThreshold;
	}

	public void setLocalThreshold(long localThreshold) {
		this.localThreshold = localThreshold;
	}

	public MongoDatabaseFactory getMongoDbFactory(String dbName, String uri) throws Exception {
		MongoDatabaseFactory mongoDatabaseFactory = new SimpleMongoClientDatabaseFactory(getMongoClient(dbName, uri),
				dbName);
		System.out.println("MongoDatabaseFactory created...");
		return mongoDatabaseFactory;
	}

	public MongoClient getMongoClient(String dbName, String uri) {
		MongoClient mongoClient = MongoClients.create(getMongoClientSettings(dbName, uri));
		System.out.println("MongoClient created...");
		return mongoClient;
	}

	public MongoClientSettings getMongoClientSettings(String dbVerticalName, String uri) {
		ConnectionString connectionString = getConnectionString(uri);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//				.addCommandListener(commandListener) ??
				.applicationName("Demo-" + dbVerticalName).applyConnectionString(connectionString)
				.applyToClusterSettings(builder -> builder.applySettings(getClusterSettings(connectionString)))
				.applyToConnectionPoolSettings(builder -> builder.applySettings(getConnectionPoolSettings()))
				.applyToServerSettings(builder1 -> builder1.applySettings(getServerSettings()))
				.applyToSocketSettings(builder -> builder.applySettings(getSocketSettings()))
//				.applyToSslSettings(block)
//				.autoEncryptionSettings(autoEncryptionSettings)
//				.codecRegistry(codecRegistry)
//				.commandListenerList(commandListeners)
//				.compressorList(compressorList)
//				.credential(getMongoCredential())
//				.streamFactoryFactory(streamFactoryFactory)
//				.uuidRepresentation(uuidRepresentation)
				.readConcern(ReadConcern.LOCAL).readPreference(ReadPreference.primaryPreferred()).retryWrites(true)
				.retryReads(true).writeConcern(WriteConcern.MAJORITY).build();
		System.out.println("MongoClientSettings created...");
		return mongoClientSettings;
	}

	public ConnectionString getConnectionString(String uri) {
		return new ConnectionString(uri);
	}

	public ClusterSettings getClusterSettings(ConnectionString connectionString) {
		return ClusterSettings.builder()
//				.mode(ClusterConnectionMode.MULTIPLE)
//				.srvHost(connectionString.getHosts().get(0))
//				.hosts(Collections.singletonList(new ServerAddress(host, port)))
//				.requiredReplicaSetName(requiredReplicaSetName)
//				.requiredClusterType(requiredClusterType)
//				.addClusterListener(clusterListener)
				.applyConnectionString(connectionString)
				.localThreshold(localThreshold, TimeUnit.MILLISECONDS)
				.serverSelectionTimeout(serverSelectionTimeout, TimeUnit.MILLISECONDS).build();
	}

	public ConnectionPoolSettings getConnectionPoolSettings() {
		return ConnectionPoolSettings.builder().maxSize(maxSize).minSize(minSize)
				.maxWaitTime(maxWaitTime, TimeUnit.MILLISECONDS)
//				.addConnectionPoolListener(connectionPoolListener)
//				.maintenanceFrequency(maintenanceFrequency, timeUnit)
//				.maintenanceInitialDelay(maintenanceInitialDelay, timeUnit)	
				.maxConnectionLifeTime(maxConnectionLifeTime, TimeUnit.MILLISECONDS)
				.maxConnectionIdleTime(maxConnectionIdleTime, TimeUnit.MILLISECONDS).build();
	}

	public ServerSettings getServerSettings() {
		return ServerSettings.builder().minHeartbeatFrequency(minHeartbeatFrequency, TimeUnit.MILLISECONDS)
//				.addServerListener(serverListener)
//				.addServerMonitorListener(serverMonitorListener)
				.heartbeatFrequency(heartbeatFrequency, TimeUnit.MILLISECONDS).build();
	}

	public SocketSettings getSocketSettings() {
		return SocketSettings.builder().connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
//				.receiveBufferSize(receiveBufferSize)
//				.sendBufferSize(sendBufferSize)	
				.readTimeout(socketTimeout, TimeUnit.MILLISECONDS).build();
	}

}
