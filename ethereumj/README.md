# ethereumj

[![Build Status](https://travis-ci.org/Thoughtscript/ethereumj.svg?branch=master)](https://travis-ci.org/Thoughtscript/ethereumj)

Very simple Ethereum client implementation using EthereumJ, Java 8, and Spring MVC.

## Basic Strategy

Following the strategy laid out in the starter, we'll attach an Ethereum bean (EthBean) to our startup configuration so that the Ethereum object will be available application-wide.

## Gotcha's

Remember that all components (e.g. @Service, @RestController, ... annotated objects) are also beans.

@Bean specifically annotates a bean that can be injected into a configuration object.

Thus, autowiring an @Bean annotated object exposes the initialized configuration bean object into the context into which it is injected.

Remember that Spring Boot will attempt to auto-configure if it detects any @Configuration. Disable the one's you need.

## RESTful Endpoints

GET http://localhost:8080/ethereum/api/get/bestblock/

```json
//example
{
    "response": "f90218f90213a03db5f088c5a04728643381bf3ba06356bfe50e65607e1591c83bd9fe0b2c6ae9a01dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347945a1bf6acbde234acdbdb48875f825de9dd6a3348a0ab0ff2e73b05f74558ad07a54527a997d84274ada633b203c6c739146dd77f5aa056e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421a056e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421b90100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000008589fab8502c8226c0821388808455bb3afd99476574682f76312e302e302f6c696e75782f676f312e342e32a0a766f1541067a62d2e48694b3c0f06a016f7375acae0d7a122ecba0f83ef48a4884e1f234fb371f92ac0c0\nBlockData [ hash=2795338efbda70281c06cc062c7ef7a25c470662dace200cb579b5aec2d383e9\n  hash=2795338efbda70281c06cc062c7ef7a25c470662dace200cb579b5aec2d383e9\n  parentHash=3db5f088c5a04728643381bf3ba06356bfe50e65607e1591c83bd9fe0b2c6ae9\n  unclesHash=1dcc4de8dec75d7aab85b567b6ccd41ad312451b948a7413f0a142fd40d49347\n  coinbase=5a1bf6acbde234acdbdb48875f825de9dd6a3348\n  stateRoot=ab0ff2e73b05f74558ad07a54527a997d84274ada633b203c6c739146dd77f5a\n  txTrieHash=56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421\n  receiptsTrieHash=56e81f171bcc55a6ff8345e692c0f86e5b48e01b996cadc001622fb5e363b421\n  difficulty=89fab8502c\n  number=9920\n  gasLimit=1388\n  gasUsed=0\n  timestamp=1438333693 (2015.07.31 02:08:13)\n  extraData=476574682f76312e302e302f6c696e75782f676f312e342e32\n  mixHash=a766f1541067a62d2e48694b3c0f06a016f7375acae0d7a122ecba0f83ef48a4\n  nonce=4e1f234fb371f92a\nUncles []\nTxs []\n]"
}
```

GET http://localhost:8080/ethereum/api/get/difficulty/

```json
//example
{
    "response": "254301375237169104"
}
```

## Resources

https://github.com/ethereum/ethereumj

https://github.com/ether-camp/ethereumj.starter

## Versioning and Licensing

MIT Licensed. Feel free to use!
