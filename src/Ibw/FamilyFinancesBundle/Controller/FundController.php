<?php

namespace Ibw\FamilyFinancesBundle\Controller;

use Symfony\Component\HttpFoundation\Request;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

use Ibw\FamilyFinancesBundle\Entity\Fund;
use Ibw\FamilyFinancesBundle\Form\FundType;

/**
 * Fund controller.
 *
 */
class FundController extends Controller
{

    /**
     * Lists all Fund entities.
     *
     */
    public function indexAction()
    {
        $em = $this->getDoctrine()->getManager();

        $entities = $em->getRepository('IbwFamilyFinancesBundle:Fund')->findAll();

        return $this->render('IbwFamilyFinancesBundle:Fund:index.html.twig', array(
            'entities' => $entities,
        ));
    }
    /**
     * Creates a new Fund entity.
     *
     */
    public function createAction(Request $request)
    {
        $entity = new Fund();
        $form = $this->createCreateForm($entity);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $em->persist($entity);
            $em->flush();

            return $this->redirect($this->generateUrl('funds_show', array('id' => $entity->getId())));
        }

        return $this->render('IbwFamilyFinancesBundle:Fund:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
    * Creates a form to create a Fund entity.
    *
    * @param Fund $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createCreateForm(Fund $entity)
    {
        $form = $this->createForm(new FundType(), $entity, array(
            'action' => $this->generateUrl('funds_create'),
            'method' => 'POST',
        ));

        $form->add('submit', 'submit', array('label' => 'Create'));

        return $form;
    }

    /**
     * Displays a form to create a new Fund entity.
     *
     */
    public function newAction()
    {
        $entity = new Fund();
        $form   = $this->createCreateForm($entity);

        return $this->render('IbwFamilyFinancesBundle:Fund:new.html.twig', array(
            'entity' => $entity,
            'form'   => $form->createView(),
        ));
    }

    /**
     * Finds and displays a Fund entity.
     *
     */
    public function showAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Fund')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Fund entity.');
        }

        $deleteForm = $this->createDeleteForm($id);

        return $this->render('IbwFamilyFinancesBundle:Fund:show.html.twig', array(
            'entity'      => $entity,
            'delete_form' => $deleteForm->createView(),        ));
    }

    /**
     * Displays a form to edit an existing Fund entity.
     *
     */
    public function editAction($id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Fund')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Fund entity.');
        }

        $editForm = $this->createEditForm($entity);
        $deleteForm = $this->createDeleteForm($id);

        return $this->render('IbwFamilyFinancesBundle:Fund:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }

    /**
    * Creates a form to edit a Fund entity.
    *
    * @param Fund $entity The entity
    *
    * @return \Symfony\Component\Form\Form The form
    */
    private function createEditForm(Fund $entity)
    {
        $form = $this->createForm(new FundType(), $entity, array(
            'action' => $this->generateUrl('funds_update', array('id' => $entity->getId())),
            'method' => 'PUT',
        ));

        $form->add('submit', 'submit', array('label' => 'Update'));

        return $form;
    }
    /**
     * Edits an existing Fund entity.
     *
     */
    public function updateAction(Request $request, $id)
    {
        $em = $this->getDoctrine()->getManager();

        $entity = $em->getRepository('IbwFamilyFinancesBundle:Fund')->find($id);

        if (!$entity) {
            throw $this->createNotFoundException('Unable to find Fund entity.');
        }

        $deleteForm = $this->createDeleteForm($id);
        $editForm = $this->createEditForm($entity);
        $editForm->handleRequest($request);

        if ($editForm->isValid()) {
            $em->flush();

            return $this->redirect($this->generateUrl('funds_edit', array('id' => $id)));
        }

        return $this->render('IbwFamilyFinancesBundle:Fund:edit.html.twig', array(
            'entity'      => $entity,
            'edit_form'   => $editForm->createView(),
            'delete_form' => $deleteForm->createView(),
        ));
    }
    /**
     * Deletes a Fund entity.
     *
     */
    public function deleteAction(Request $request, $id)
    {
        $form = $this->createDeleteForm($id);
        $form->handleRequest($request);

        if ($form->isValid()) {
            $em = $this->getDoctrine()->getManager();
            $entity = $em->getRepository('IbwFamilyFinancesBundle:Fund')->find($id);

            if (!$entity) {
                throw $this->createNotFoundException('Unable to find Fund entity.');
            }

            $em->remove($entity);
            $em->flush();
        }

        return $this->redirect($this->generateUrl('funds'));
    }

    /**
     * Creates a form to delete a Fund entity by id.
     *
     * @param mixed $id The entity id
     *
     * @return \Symfony\Component\Form\Form The form
     */
    private function createDeleteForm($id)
    {
        return $this->createFormBuilder()
            ->setAction($this->generateUrl('funds_delete', array('id' => $id)))
            ->setMethod('DELETE')
            ->add('submit', 'submit', array('label' => 'Delete'))
            ->getForm()
        ;
    }
}
