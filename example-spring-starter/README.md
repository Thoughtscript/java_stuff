# example-spring-starter

We'll build a small distributed Twitter app that will stream Twitter posts into a Hadoop Distributed File System. That'll give us a chance to work with examples from kind of starter app. 

If there's time, we'll then extract those into a CSV file. Let's get started (pun fully intended)!

# Setup

We'll set this example up in three parts:

(1) Sign up for an apps.twitter account. We'll use the consumer-key and access-token to create a simple Twitter app using the Twitter Spring Cloud Stream App Starter. Account sign up is here: https://apps.twitter.com/

(2) We'll then set up Hadoop so we can persist our Twitter Stream for future Big Data purposes. 
To install, take a look at the bash script in '/bash/hadoop.sh'

(3a) To actually connect our Twitter account to Hadoop we can use the supplied Spring GitHub repositories to compile and assemble standalone components of the _sources-sinks-processors_ aggregate application architecture pattern using Maven:

### Twitter Stream Starter

This piece will stream Twitter messages and submit them to the HDFS Stream component.

```bash
# Git spring-cloud-stream-app-starters
# https://github.com/spring-cloud-stream-app-starters/hdfs/blob/master/spring-cloud-starter-stream-sink-hdfs/README.adoc
git clone https://github.com/spring-cloud-stream-app-starters/twitter.git

# Build it
./mvnw clean install -PgenerateApps

# RUn it
cd apps
# Optionally inject application.properties prior to build
java -jar twitter_stream_source.jar --consumerKey=<CONSUMER_KEY> --consumerSecret=<CONSUMER_SECRET> \
    --accessToken=<ACCESS_TOKEN> --accessTokenSecret=<ACCESS_TOKEN_SECRET>
```

### HDFS Stream Starter

The HDFS Stream piece consumes Twitter messages and persists them to a specified HDFS.

```bash
# Git spring-cloud-stream-app-starters
# https://github.com/spring-cloud-stream-app-starters/hdfs/blob/master/spring-cloud-starter-stream-sink-hdfs/README.adoc
git clone https://github.com/spring-cloud-stream-app-starters/hdfs.git

# Build it
./mvnw clean install -PgenerateApps

# Run it
cd apps
# Optionally inject application.properties prior to build
java -jar hdfs-sink.jar --fsUri=hdfs://127.0.0.1:50010/
```

(3b) Alternatively, we can use the recommended way to combine Spring Stream components together combining `sources`, `processors`, and `sinks` through their binding interfaces:

```java
@SpringBootApplication
public class SampleAggregateApplication {

	public static void main(String[] args) {
		new AggregateApplicationBuilder()
			.from(SourceApplication.class).args("--fixedDelay=5000")
			.via(ProcessorApplication.class)
			.to(SinkApplication.class).args("--debug=true").run(args);
	}
}
```

See: https://docs.spring.io/spring-cloud-stream/docs/Elmhurst.M3/reference/html/_programming_model.html#_aggregation

```bash
    $ mvn install
    $ java -jar twitterhdfs.jar
```

You'll then see:

```bash
2018-01-15 04:48:41.897  INFO 29155 --- [itterSource-1-1] c.b.twitterhdfs.processor.ProcessorApp   : Payload received!
2018-01-15 04:48:41.897  INFO 29155 --- [itterSource-1-1] com.baeldung.twitterhdfs.sink.SinkApp    : Received: {"created_at":"Mon Jan 15 04:48:42 +0000 2018","id":952764456802516993,"id_str":"952764456802516993","text":"RT @s_kurosaki: \u3064\u3044\u306b\u2026 https:\/\/t.co\/EAL5bOq75q","source":"\u003ca href=\"https:\/\/twitter.com\/ABS104a\" rel=\"nofollow\"\u003eBiyon\u2261(\u3000\u03b5:) Pro\u003c\/a\u003e","truncated":false,"in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":721998925494820866,"id_str":"721998925494820866","name":"\u305b\u3063\u3051\u3093","screen_name":"paos41_1","location":"\u5343\u8449\u2190\u2192\u6771\u4eac","url":null,"description":"\u30c1\u30ad\u30f3\ud83d\udc14\u306a\u58f0\u8c5a\ud83d\udc37..............\n\u5343\u8449\u306e\u3057\u3087\u307c\u3044\u5c0f\u5b66\u6821\u2192\u305d\u306e\u8fd1\u304f\u306e\u30b4\u30df\u4e2d\u5b66\u6821\u2192\u6771\u4eac\u795e\u5948\u5ddd\u306e\u5883\u306e\u30af\u30bd\u9ad8\u6821\u2192\u90fd\u4f1a\u306e\u3078\u3093\u306a\u5c02\u9580\u5b66\u6821","translator_type":"none","protected":false,"verified":false,"followers_count":213,"friends_count":584,"listed_count":1,"favourites_count":7149,"statuses_count":56427,"created_at":"Mon Apr 18 09:48:52 +0000 2016","utc_offset":-28800,"time_zone":"Pacific Time (US & Canada)","geo_enabled":false,"lang":"ja","contributors_enabled":false,"is_translator":false,"profile_background_color":"000000","profile_background_image_url":"http:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_image_url_https":"https:\/\/abs.twimg.com\/images\/themes\/theme1\/bg.png","profile_background_tile":false,"profile_link_color":"0084B4","profile_sidebar_border_color":"000000","profile_sidebar_fill_color":"000000","profile_text_color":"000000","profile_use_background_image":false,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/721999281566003201\/Hw9R6l7N_normal.jpg","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/721999281566003201\/Hw9R6l7N_normal.jpg","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/721998925494820866\/1479364196","default_profile":false,"default_profile_image":false,"following":null,"follow_request_sent":null,"notifications":null},"geo":null,"coordinates":null,"place":null,"contributors":null,"retweeted_status":{"created_at":"Mon Jan 15 03:05:05 +0000 2018","id":952738379136876544,"id_str":"952738379136876544","text":"\u3064\u3044\u306b\u2026 https:\/\/t.co\/EAL5bOq75q","display_text_range":[0,4],"source":"\u003ca href=\"http:\/\/twitter.com\/download\/android\" rel=\"nofollow\"\u003eTwitter for Android\u003c\/a\u003e","truncated":false,"in_reply_to_status_id":null,"in_reply_to_status_id_str":null,"in_reply_to_user_id":null,"in_reply_to_user_id_str":null,"in_reply_to_screen_name":null,"user":{"id":93147655,"id_str":"93147655","name":"\u9ed2\u5d0e","screen_name":"s_kurosaki","location":"\u307f\u3093\u306a\u306e\u3076\u3069\u30fc\u304b\u3093","url":"http:\/\/www.nicovideo.jp\/user\/15166922","description":"\u96e8\u306e\u4e2d\u3001\u670d\u3092\u7740\u305a\u306b\u8e0a\u308b\u4eba\u9593\u304c\u3044\u3066\u3082\u3044\u3044\u3002\u81ea\u7531\u3068\u306f\u305d\u3046\u3044\u3046\u3053\u3068\u3060\u3002","translator_type":"none","protected":false,"verified":false,"followers_count":1694,"friends_count":425,"listed_count":43,"favourites_count":4700,"statuses_count":60442,"created_at":"Sat Nov 28 08:47:08 +0000 2009","utc_offset":32400,"time_zone":"Tokyo","geo_enabled":false,"lang":"ja","contributors_enabled":false,"is_translator":false,"profile_background_color":"131516","profile_background_image_url":"http:\/\/abs.twimg.com\/images\/themes\/theme14\/bg.gif","profile_background_image_url_https":"https:\/\/abs.twimg.com\/images\/themes\/theme14\/bg.gif","profile_background_tile":true,"profile_link_color":"1B95E0","profile_sidebar_border_color":"FFFFFF","profile_sidebar_fill_color":"EFEFEF","profile_text_color":"333333","profile_use_background_image":true,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/875529011761434624\/e6kS3tHN_normal.png","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/875529011761434624\/e6kS3tHN_normal.png","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/93147655\/1478783161","default_profile":false,"default_profile_image":false,"following":null,"follow_request_sent":null,"notifications":null},"geo":null,"coordinates":null,"place":null,"contributors":null,"is_quote_status":false,"quote_count":0,"reply_count":0,"retweet_count":112,"favorite_count":37,"entities":{"hashtags":[],"urls":[],"user_mentions":[],"symbols":[],"media":[{"id":952738358018523136,"id_str":"952738358018523136","indices":[5,28],"media_url":"http:\/\/pbs.twimg.com\/media\/DTjOfSGVQAAwq-l.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/DTjOfSGVQAAwq-l.jpg","url":"https:\/\/t.co\/EAL5bOq75q","display_url":"pic.twitter.com\/EAL5bOq75q","expanded_url":"https:\/\/twitter.com\/s_kurosaki\/status\/952738379136876544\/photo\/1","type":"photo","sizes":{"medium":{"w":675,"h":1200,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"large":{"w":1080,"h":1920,"resize":"fit"},"small":{"w":383,"h":680,"resize":"fit"}}}]},"extended_entities":{"media":[{"id":952738358018523136,"id_str":"952738358018523136","indices":[5,28],"media_url":"http:\/\/pbs.twimg.com\/media\/DTjOfSGVQAAwq-l.jpg","media_url_https":"https:\/\/pbs.twimg.com\/media\/DTjOfSGVQAAwq-l.jpg","url":"https:\/\/t.co\/EAL5bOq75q","display_url":"pic.twitter.com\/EAL5bOq75q","expanded_url":"https:\/\/twitter.com\/s_kurosaki\/status\/952738379136876544\/photo\/1","type":"photo","sizes":{"medium":{"w":675,"h":1200,"resize":"fit"},"thumb":{"w":150,"h":150,"resize":"crop"},"large":{"w":1080,"h":1920,"resize":"fit"},"small":{"w":383,"h":680,"resize":"fit"}}}]},"favorited":false,"retweeted":false,"possibly_sensitive":false,"filter_level":"lo^C":"","profile_background_image_url_https":"","profile_background_tile":false,"profile_link_color":"1DA1F2","profile_sidebar_border_color":"C0DEED","profile_sidebar_fill_color":"DDEEF6","profile_text_color":"333333","profile_use_background_image":true,"profile_image_url":"http:\/\/pbs.twimg.com\/profile_images\/952512957908271105\/xVZ5JXJT_normal.jpg","profile_image_url_https":"https:\/\/pbs.twimg.com\/profile_images\/952512957908271105\/xVZ5JXJT_normal.jpg","profile_banner_url":"https:\/\/pbs.twimg.com\/profile_banners\/952502744216059905\/1515951255","default_profile":true,"default_profile_image":false,"following":null,"follow_request_sent":null,"notifications":null},"geo":null,"coordinates":null,"place":null,"contributors":null,"is_quote_status":false,"quote_count":0,"reply_count":0,"retweet_count":0,"favorite_count":0,"entities":{"hashtags":[],"urls":[],"user_mentions":[{"screen_name":"Ragnarok_B","name":"\ube0c\ub8e8\ud23c","id":952510358224171010,"id_str":"952510358224171010","indices":[0,11]}],"symbols":[]},"favorited":false,"retweeted":false,"filter_level":"low","lang":"ko","timestamp_ms":"1515991722660"}
```

Pleae note that this is not configured to modify the Hadoop HDFS system. Rather, it will connect and print out a simple message per the output above.

# Resources and Shout-outs

Official Docs: https://github.com/spring-cloud/spring-cloud-stream-app-starters/tree/master/twitter/spring-cloud-starter-stream-source-twitterstream

https://github.com/spring-cloud-stream-app-starters/hdfs

https://github.com/tzolov/tensorflow-spring-cloud-stream-app-starters

Shout-Out: https://github.com/sufinawaz/spring-boot-starter-app/blob/master/pom.xml

(Stream Cloud Stater Apps were not compiling the correct codebase unti lI also added target and source via maven-compiler-plugin.)

# Licensing and Versioning

This is MIT licensed! It's not ready to be consumed until it has a star.
