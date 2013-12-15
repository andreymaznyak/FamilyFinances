<?php

namespace Ibw\FamilyFinancesBundle\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Income
 */
class Income
{
    /**
     * @var integer
     */
    private $id;

    /**
     * @var string
     */
    private $name;

    /**
     * @var \Doctrine\Common\Collections\Collection
     */
    private $userIncomes;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->userIncomes = new \Doctrine\Common\Collections\ArrayCollection();
    }

    /**
     * Get id
     *
     * @return integer 
     */
    public function getId()
    {
        return $this->id;
    }

    /**
     * Set name
     *
     * @param string $name
     * @return Income
     */
    public function setName($name)
    {
        $this->name = $name;

        return $this;
    }

    /**
     * Get name
     *
     * @return string 
     */
    public function getName()
    {
        return $this->name;
    }

    /**
     * Add userIncomes
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes
     * @return Income
     */
    public function addUserIncome(\Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes)
    {
        $this->userIncomes[] = $userIncomes;

        return $this;
    }

    /**
     * Remove userIncomes
     *
     * @param \Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes
     */
    public function removeUserIncome(\Ibw\FamilyFinancesBundle\Entity\UserIncome $userIncomes)
    {
        $this->userIncomes->removeElement($userIncomes);
    }

    /**
     * Get userIncomes
     *
     * @return \Doctrine\Common\Collections\Collection 
     */
    public function getUserIncomes()
    {
        return $this->userIncomes;
    }
	
	public function __toString()
	{
		return $this->name;
	}
}
