# Coderwall-java [![endorse](http://api.coderwall.com/alessandroleite/endorsecount.png)](http://coderwall.com/alessandroleite)

Coderwall Java Client API

## Usage

```
Coder coder = new CoderwallClient("alessandroleite").get();

for(Badge badge: code.getBadges())
{
	System.out.printf("Name:%s Description:%s Created in: %s Badge icon: %s", 
					   badge.getName(), badge.getDescription(), badge.getCreated(), badge.getBadge());	
}
```

## Contributing

1. Fork it
2. Create your feature branch (`git checkout -b your-new-feature`)
3. Commit your changes (`git commit -am 'Added some feature'`)
4. Push to the branch (`git push origin your-new-feature`)
5. Create new Pull Request

## License 

The project is licensed under the MIT license. 
See License.txt for details.