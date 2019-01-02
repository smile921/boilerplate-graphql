#  a practise project with graphql

## [graphql-java 初探](https://www.graphql-java.com/documentation/v11/)

* [根据这个文档完成第一步](https://www.graphql-java.com/documentation/v11/getting-started/)
初始化项目基本可以。
* [第二步](https://www.graphql-java.com/documentation/v11/schema/) 不知道什么原因做不下去了。查查资料，换个姿势 [看完这个文档](https://www.graphql-java-kickstart.com/tools/schema-definition/)再去实现这个schema 到java的过程貌似有点眉目了。

> GraphQL Java Tools maps fields on your GraphQL objects to methods and properties on your java objects. For most scalar fields, a POJO with fields and/or getter methods is enough to describe the data to GraphQL. More complex fields (like looking up another object) often need more complex methods with state not provided by the GraphQL context (repositories, connections, etc). GraphQL Java Tools uses the concept of “Data Classes” and “Resolvers” to account for both of these situations.

> GraphQL Java Tools 把 GraphQL 对象的 熟悉和方法 映射到 Java 的熟性和方法。对于绝大多数 scalar 成员 一个简单的 POJO 对象 有成员和 getter 方法就足以描述 GraphQL 的数据对象了。对于更复杂的成员引用了另外一个对象的情况， GraphQL Java Tools 使用 Data Classes 和 Resolvers 来实现这个情况。

* [第三步](https://www.graphql-java.com/documentation/v11/data-fetching/)
  根据第二步的探索研究，接下来重点是实现 Data Fetcher。 即先通过 SchemaParser parse schema 得到一个parser 再得到TypeDefinitionRegistry ，再构建对应的 RuntimeWiring 。而这个 RuntimeWiring 主要是找到对于的 Data Fetcher . 接下来只需要实现 DataFetcher 。
  Data Fetcher 会有一个 DataFetchingEnvironment , 根据 DataFetchingEnvironment 可以找到对于的 repository 大抵如此吧。
```java
        DataFetcher productsDataFetcher = new DataFetcher<List<ProductDTO>>() {
            @Override
            public List<ProductDTO> get(DataFetchingEnvironment environment) {
                DatabaseSecurityCtx ctx = environment.getContext();

                List<ProductDTO> products;
                String match = environment.getArgument("match");
                if (match != null) {
                    products = fetchProductsFromDatabaseWithMatching(ctx, match);
                } else {
                    products = fetchAllProductsFromDatabase(ctx);
                }
                return products;
            }
        };
```
        
  