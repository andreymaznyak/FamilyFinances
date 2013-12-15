<?php

namespace Ibw\FamilyFinancesBundle\Form;

use Symfony\Component\Form\AbstractType;
use Symfony\Component\Form\FormBuilderInterface;
use Symfony\Component\OptionsResolver\OptionsResolverInterface;

class FundType extends AbstractType
{
        /**
     * @param FormBuilderInterface $builder
     * @param array $options
     */
    public function buildForm(FormBuilderInterface $builder, array $options)
    {
        $builder
            ->add('name',null,array('label' => 'Название'))
            ->add('is_periodic',null,array('label' => 'Периодичный'))
            ->add('period',null,array('label' => 'Период'))
            ->add('period_limit',null,array('label' => 'Лимит'))
            ->add('users',null,array('label' => 'Пользователи'))
			->add('created_at','date',array('input'  => 'datetime',
								'widget' => 'single_text',
								'label' => 'Дата создания'))
        ;
    }
    
    /**
     * @param OptionsResolverInterface $resolver
     */
    public function setDefaultOptions(OptionsResolverInterface $resolver)
    {
        $resolver->setDefaults(array(
            'data_class' => 'Ibw\FamilyFinancesBundle\Entity\Fund'
        ));
    }

    /**
     * @return string
     */
    public function getName()
    {
        return 'ibw_familyfinancesbundle_fund';
    }
}
