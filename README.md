停车场

迭代一

需求列表：

需求1： 有一个停车场和管理员，管理员可以存放和取回客人的车辆；

需求2： 如果停车场有空位，则管理员允许客人停车

需求3： 停车场存在的车辆可以离开停车场，并恢复所占车位

词汇表： 停车场：Parking Lot 泊车：Park 离场：Depart 管理员：Admin

迭代二

需求列表：

需求1：停车场变成多个，管理员按顺序停放车辆，即一个停车场满了再放入下一个停车场

需求2：停车管理员按照哪个停车场空位多将车放入哪个停车场

需求3：停车管理员按照哪个停车场空置率大将车放入哪个停车场

迭代三

需求：扩建为多个停车楼，每个停车楼有多个停车场，每个停车楼有一个停车管理员，
原先的管理员升职为经理，经理可以按照迭代二的任意策略将车辆分配给某个停车管理员，
管理员可以按照迭代二的任意策略停放车辆