#  a practise project with graphql

## [graphql-java ��̽](https://www.graphql-java.com/documentation/v11/)

* [��������ĵ���ɵ�һ��](https://www.graphql-java.com/documentation/v11/getting-started/)
��ʼ����Ŀ�������ԡ�
* [�ڶ���](https://www.graphql-java.com/documentation/v11/schema/) ��֪��ʲôԭ��������ȥ�ˡ�������ϣ��������� [��������ĵ�](https://www.graphql-java-kickstart.com/tools/schema-definition/)��ȥʵ�����schema ��java�Ĺ���ò���е�üĿ�ˡ�

> GraphQL Java Tools maps fields on your GraphQL objects to methods and properties on your java objects. For most scalar fields, a POJO with fields and/or getter methods is enough to describe the data to GraphQL. More complex fields (like looking up another object) often need more complex methods with state not provided by the GraphQL context (repositories, connections, etc). GraphQL Java Tools uses the concept of ��Data Classes�� and ��Resolvers�� to account for both of these situations.

> GraphQL Java Tools �� GraphQL ����� ��Ϥ�ͷ��� ӳ�䵽 Java �����Ժͷ��������ھ������ scalar ��Ա һ���򵥵� POJO ���� �г�Ա�� getter �������������� GraphQL �����ݶ����ˡ����ڸ����ӵĳ�Ա����������һ������������ GraphQL Java Tools ʹ�� Data Classes �� Resolvers ��ʵ����������

* [������](https://www.graphql-java.com/documentation/v11/data-fetching/)
  ���ݵڶ�����̽���о����������ص���ʵ�� Data Fetcher�� ����ͨ�� SchemaParser parse schema �õ�һ��parser �ٵõ�TypeDefinitionRegistry ���ٹ�����Ӧ�� RuntimeWiring ������� RuntimeWiring ��Ҫ���ҵ����ڵ� Data Fetcher . ������ֻ��Ҫʵ�� DataFetcher ��
  Data Fetcher ����һ�� DataFetchingEnvironment , ���� DataFetchingEnvironment �����ҵ����ڵ� repository �����˰ɡ�
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
        
  