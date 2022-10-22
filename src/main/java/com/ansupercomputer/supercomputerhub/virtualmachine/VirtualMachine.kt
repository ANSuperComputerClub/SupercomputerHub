package com.ansupercomputer.supercomputerhub.virtualmachine

import com.ansupercomputer.supercomputerhub.user.User

/**
 * Class that represents a Docker instance
 * @param id Docker instance id
 * @param cores How many cores the Docker instance is allowed to use
 * @param ram How much ram the Docker instance is allowed to use in GB
 * @param storage How much storage Docker instance is allowed to use in GB
 * @param owner Which owner the Docker instance belongs to
 */
class VirtualMachine (var id: Int, var cores: Int, var ram: Int, var storage: Int, var owner: User) {

}
